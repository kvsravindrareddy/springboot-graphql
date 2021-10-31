package com.veera.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.veera.entity.AppResponse;
import com.veera.entity.OrgEntity;
import com.veera.entity.ProductEntity;
import com.veera.repo.OrgRepo;
import com.veera.repo.ProductRepo;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class AppService {
	
	private ProductRepo productRepo;
	
	
	private OrgRepo orgRepo;
	
	public AppService(ProductRepo productRepo, OrgRepo orgRepo)
	{
		this.productRepo = productRepo;
		this.orgRepo = orgRepo;
	}
	
	@GraphQLMutation(name="data")
	public AppResponse createData(@GraphQLArgument(name = "productEntity")ProductEntity productEntity,
			@GraphQLArgument(name="orgEntity")OrgEntity orgEntity)
	{
		String response = null;
		if(null!=productEntity)
		{
			productRepo.save(productEntity);
			response = "Product";
		} else if(null!=orgEntity)
		{
			orgRepo.save(orgEntity);
			response = "Org";
		}
		AppResponse appResponse = new AppResponse();
		appResponse.setResponse(response);
		return appResponse;
	}
	
	@GraphQLQuery(name="products")
	public List<ProductEntity> products()
	{
		return productRepo.findAll();
	}
	
	@GraphQLQuery(name="org")
	public List<OrgEntity> orgDetails()
	{
		return orgRepo.findAll();
	}
}