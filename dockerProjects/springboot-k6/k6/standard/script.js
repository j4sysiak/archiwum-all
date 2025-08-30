import { check } from "k6";
import http from "k6/http";

export default function() {
    let res = http.get("http://localhost:8080/api/navigation");
    check(res, {
        "is status 200": (r) => r.status === 200
    });
};