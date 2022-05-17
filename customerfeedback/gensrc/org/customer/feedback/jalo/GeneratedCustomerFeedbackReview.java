/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 15, 2022 11:00:27 PM                    ---
 * ----------------------------------------------------------------
 */
package org.customer.feedback.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.customer.feedback.constants.CustomerfeedbackConstants;

/**
 * Generated class for type {@link org.customer.feedback.jalo.CustomerFeedbackReview CustomerFeedbackReview}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCustomerFeedbackReview extends GenericItem
{
	/** Qualifier of the <code>CustomerFeedbackReview.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>CustomerFeedbackReview.content</code> attribute **/
	public static final String CONTENT = "content";
	/** Qualifier of the <code>CustomerFeedbackReview.language</code> attribute **/
	public static final String LANGUAGE = "language";
	/** Qualifier of the <code>CustomerFeedbackReview.approved</code> attribute **/
	public static final String APPROVED = "approved";
	/** Qualifier of the <code>CustomerFeedbackReview.user</code> attribute **/
	public static final String USER = "user";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n USER's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedCustomerFeedbackReview> USERHANDLER = new BidirectionalOneToManyHandler<GeneratedCustomerFeedbackReview>(
	CustomerfeedbackConstants.TC.CUSTOMERFEEDBACKREVIEW,
	false,
	"user",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(CONTENT, AttributeMode.INITIAL);
		tmp.put(LANGUAGE, AttributeMode.INITIAL);
		tmp.put(APPROVED, AttributeMode.INITIAL);
		tmp.put(USER, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.approved</code> attribute.
	 * @return the approved - Review is approved
	 */
	public Boolean isApproved(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, APPROVED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.approved</code> attribute.
	 * @return the approved - Review is approved
	 */
	public Boolean isApproved()
	{
		return isApproved( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.approved</code> attribute. 
	 * @return the approved - Review is approved
	 */
	public boolean isApprovedAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isApproved( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.approved</code> attribute. 
	 * @return the approved - Review is approved
	 */
	public boolean isApprovedAsPrimitive()
	{
		return isApprovedAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.approved</code> attribute. 
	 * @param value the approved - Review is approved
	 */
	public void setApproved(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, APPROVED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.approved</code> attribute. 
	 * @param value the approved - Review is approved
	 */
	public void setApproved(final Boolean value)
	{
		setApproved( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.approved</code> attribute. 
	 * @param value the approved - Review is approved
	 */
	public void setApproved(final SessionContext ctx, final boolean value)
	{
		setApproved( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.approved</code> attribute. 
	 * @param value the approved - Review is approved
	 */
	public void setApproved(final boolean value)
	{
		setApproved( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.content</code> attribute.
	 * @return the content - Content of the review
	 */
	public String getContent(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CONTENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.content</code> attribute.
	 * @return the content - Content of the review
	 */
	public String getContent()
	{
		return getContent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.content</code> attribute. 
	 * @param value the content - Content of the review
	 */
	public void setContent(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CONTENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.content</code> attribute. 
	 * @param value the content - Content of the review
	 */
	public void setContent(final String value)
	{
		setContent( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		USERHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.language</code> attribute.
	 * @return the language - Language of the review.
	 */
	public Language getLanguage(final SessionContext ctx)
	{
		return (Language)getProperty( ctx, LANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.language</code> attribute.
	 * @return the language - Language of the review.
	 */
	public Language getLanguage()
	{
		return getLanguage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.language</code> attribute. 
	 * @param value the language - Language of the review.
	 */
	public void setLanguage(final SessionContext ctx, final Language value)
	{
		setProperty(ctx, LANGUAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.language</code> attribute. 
	 * @param value the language - Language of the review.
	 */
	public void setLanguage(final Language value)
	{
		setLanguage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.title</code> attribute.
	 * @return the title - Title of the review
	 */
	public String getTitle(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.title</code> attribute.
	 * @return the title - Title of the review
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.title</code> attribute. 
	 * @param value the title - Title of the review
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.title</code> attribute. 
	 * @param value the title - Title of the review
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.user</code> attribute.
	 * @return the user
	 */
	public User getUser(final SessionContext ctx)
	{
		return (User)getProperty( ctx, USER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomerFeedbackReview.user</code> attribute.
	 * @return the user
	 */
	public User getUser()
	{
		return getUser( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.user</code> attribute. 
	 * @param value the user
	 */
	public void setUser(final SessionContext ctx, final User value)
	{
		USERHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomerFeedbackReview.user</code> attribute. 
	 * @param value the user
	 */
	public void setUser(final User value)
	{
		setUser( getSession().getSessionContext(), value );
	}
	
}
