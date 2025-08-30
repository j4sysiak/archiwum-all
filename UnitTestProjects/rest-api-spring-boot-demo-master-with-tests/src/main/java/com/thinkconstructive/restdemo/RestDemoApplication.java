package com.thinkconstructive.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestDemoApplication.class, args);
    }

//	@Bean
//	public Docket swaggerConfiguration(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.paths(PathSelectors.ant("/cloudvendor/*"))
//				.apis(RequestHandlerSelectors.basePackage("com.thinkconstructive.restdemo"))
//				.build()
//				.apiInfo(apiCustomData());
//	}

//	private ApiInfo apiCustomData(){
//		return new ApiInfo(
//				"Cloud Vendor API Application",
//				"Cloud Vendor Documentation",
//				"1.0",
//				"Cloud Vendor Service Terms",
//				new Contact("Esha Puri", "http://thinkconstructive.com",
//						"contact@thinkconstructive.com"),
//				"Think Constructive License",
//				"http://thinkconstructive.com",
//				Collections.emptyList()
//		);
//	}

//	@Bean
//	public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(
//			WebEndpointsSupplier webEndpointsSupplier,
//			ServletEndpointsSupplier servletEndpointsSupplier,
//			ControllerEndpointsSupplier controllerEndpointsSupplier,
//			EndpointMediaTypes endpointMediaTypes,
//			CorsEndpointProperties corsProperties,
//			WebEndpointProperties webEndpointProperties,
//			Environment environment) {
//		List<ExposableEndpoint<?>> allEndpoints = new ArrayList();
//		Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
//		allEndpoints.addAll(webEndpoints);
//		allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
//		allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
//		String basePath = webEndpointProperties.getBasePath();
//		EndpointMapping endpointMapping = new EndpointMapping(basePath);
//		boolean shouldRegisterLinksMapping = this.shouldRegisterLinksMapping(
//				webEndpointProperties, environment, basePath);
//		return new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints,
//				endpointMediaTypes, corsProperties.toCorsConfiguration(),
//				new EndpointLinksResolver(allEndpoints, basePath),
//				shouldRegisterLinksMapping, null);
//	}

//    private boolean shouldRegisterLinksMapping(WebEndpointProperties webEndpointProperties,
//                                               Environment environment, String basePath) {
//        return webEndpointProperties.getDiscovery().isEnabled() &&
//                (StringUtils.hasText(basePath) ||
//                        ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
//    }
}

