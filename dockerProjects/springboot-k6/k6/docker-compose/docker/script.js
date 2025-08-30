import { check } from "k6";
import http from "k6/http";

export let options = {

    // Either specify vus + duration or stages
    // vus: 10,
    // duration: "5m",

    // This stages configuration will ramp to 50 Virtual Users over a minute,
    // maintain those 50 concurrent users for 10 minutes
    // then ramp down to 0 over a minute:
    stages: [
        { duration: "10s", target: 2 },
        { duration: "5s", target: 2 },
        { duration: "7s", target: 0 }
    ],

    // Don't save the bodies of HTTP responses by default, for improved performance
    // Can be overwritten by setting the `responseType` option to `text` or `binary` for individual requests
    discardResponseBodies: true,

    ext: {
        loadimpact: {
            // Specify the distribution across load zones
            //
            // See https://docs.k6.io/docs/cloud-execution#section-cloud-execution-options
            //
            distribution: {
                loadZoneLabel1: { loadZone: "amazon:ie:dublin", percent: 100 },

                // Uncomment this and make sure percentage distribution adds up to 100 to use two load zones.
                // loadZoneLabel2: { loadZone: "amazon:ie:dublin", percent: 50 }
            }
        }
    }
};

export default function() {
    let res = http.get("http://127.0.0.1:8080/api/navigation");
    check(res, {
        "is status 200": (r) => r.status === 200
    });
};