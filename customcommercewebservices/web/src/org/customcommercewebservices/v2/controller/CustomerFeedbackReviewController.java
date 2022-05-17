package org.customcommercewebservices.v2.controller;

import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdAndUserIdParam;

import java.util.List;

import org.customcommercewebservices.dto.CustomerFeedbackReviewWsDTO;
import org.customer.feedback.model.CustomerFeedbackReviewModel;
import org.customer.feedback.service.CustomerFeedbackService;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Controller
@RequestMapping(value = "/{baseSiteId}/users/{userId}/feedbacks")
@Api(tags = "CustomerFeedback")
public class CustomerFeedbackReviewController extends BaseController
{
	private static final Logger LOG = LoggerFactory.getLogger(CustomerFeedbackReviewController.class);

	@Resource
	private CustomerFeedbackService CustomerFeedbackService;

	@RequestMapping(method = RequestMethod.GET)
	@Secured(
			{ "ROLE_CLIENT", "ROLE_TRUSTED_CLIENT" })
	@ResponseBody
	@ApiOperation(value = "Get all Customer Feedback Reviews for user.")
	@ApiBaseSiteIdAndUserIdParam
	public ResponseEntity<List<CustomerFeedbackReviewWsDTO>> getCustomerFeedbackReviews(
			@ApiParam(value = "Response configuration. This is the list of fields that should be returned in the response body.", allowableValues = "BASIC, DEFAULT, FULL") @RequestParam(required = false, defaultValue = DEFAULT_FIELD_SET) final String fields
	)
	{
		LOG.info("New request received...");

		List<CustomerFeedbackReviewModel> feedbackReviewsForCurrentCustomer = CustomerFeedbackService
				.getAllCustomerFeedbackReviewsForCurrentCustomer();

		return ResponseEntity.ok(getDataMapper().mapAsList(feedbackReviewsForCurrentCustomer, CustomerFeedbackReviewWsDTO.class, fields));
	}
}
