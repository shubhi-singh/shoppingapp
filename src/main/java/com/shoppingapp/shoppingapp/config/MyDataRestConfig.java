package com.shoppingapp.shoppingapp.config;

import com.shoppingapp.shoppingapp.entity.Product;
import com.shoppingapp.shoppingapp.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod theUnsupportedAction[] = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> {
                    return httpMethods.disable(theUnsupportedAction);
                }))
                .withCollectionExposure((metdata, httpMethods) -> {
                    return httpMethods.disable(theUnsupportedAction);
                });
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> {
                    return httpMethods.disable(theUnsupportedAction);
                }))
                .withCollectionExposure((metdata, httpMethods) -> {
                    return httpMethods.disable(theUnsupportedAction);
                });

    }
}
