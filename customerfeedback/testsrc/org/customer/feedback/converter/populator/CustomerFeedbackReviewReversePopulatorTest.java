package org.customer.feedback.converter.populator;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.user.UserService;

import org.customer.feedback.data.CustomerFeedbackReviewData;
import org.customer.feedback.model.CustomerFeedbackReviewModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class CustomerFeedbackReviewReversePopulatorTest extends TestCase
{
	private static final String LANG_ISO_CODE = "en";
	private static final String REVIEW_TITLE = "title";
	private static final String REVIEW_CONTENT = "content";

	@InjectMocks
	private CustomerFeedbackReviewReversePopulator populator = new CustomerFeedbackReviewReversePopulator();

	@Mock
	private CommonI18NService commonI18NService;

	@Mock
	private UserService userService;

	@Mock
	private UserModel userModel;

	@Mock
	private LanguageModel languageModel;

	@Test
	public void testPopulate()
	{
		when(userService.getCurrentUser()).thenReturn(userModel);
		when(commonI18NService.getLanguage(LANG_ISO_CODE)).thenReturn(languageModel);

		CustomerFeedbackReviewData source = new CustomerFeedbackReviewData();
		source.setLang(LANG_ISO_CODE);
		source.setTitle(REVIEW_TITLE);
		source.setContent(REVIEW_CONTENT);

		CustomerFeedbackReviewModel target = new CustomerFeedbackReviewModel();
		populator.populate(source, target);

		assertEquals(languageModel, target.getLanguage());
		assertEquals(REVIEW_TITLE, target.getTitle());
		assertEquals(REVIEW_CONTENT, target.getContent());
		assertEquals(userModel, target.getUser());
	}
}