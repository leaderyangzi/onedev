package com.pmease.gitplex.web.page.organization;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import com.pmease.gitplex.core.entity.Account;

@SuppressWarnings("serial")
public class OrganizationOverviewPanel extends GenericPanel<Account> {

	public OrganizationOverviewPanel(String id, IModel<Account> model) {
		super(id, model);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(OrganizationResourceReference.INSTANCE));
	}

}