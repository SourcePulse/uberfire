/*
 * Copyright 2012 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.uberfire.client.workbench.widgets.panels;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.uberfire.client.mvp.UberView;
import org.uberfire.client.workbench.model.PartDefinition;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RequiresResize;

/**
 * A Workbench panel part.
 */
@Dependent
public class WorkbenchPartPresenter {

    public interface View
            extends
            UberView<WorkbenchPartPresenter>,
            RequiresResize {

        WorkbenchPartPresenter getPresenter();

        void setWrappedWidget( IsWidget widget );

        IsWidget getWrappedWidget();
    }

    private View view;

    private IsWidget titleWidget;

    private PartDefinition definition;

    @Inject
    public WorkbenchPartPresenter( final View view ) {
        this.view = view;
    }

    @SuppressWarnings("unused")
    @PostConstruct
    private void init() {
        view.init( this );
    }

    public PartDefinition getDefinition() {
        return definition;
    }

    public void setDefinition( final PartDefinition definition ) {
        this.definition = definition;
    }

    public IsWidget getTitleWidget() {
        return titleWidget;
    }

    public void setTitleWidget( final IsWidget titleWidget ) {
        this.titleWidget = titleWidget;
    }

    public View getPartView() {
        return view;
    }

    public void setWrappedWidget( final IsWidget widget ) {
        this.view.setWrappedWidget( widget );
    }

}
