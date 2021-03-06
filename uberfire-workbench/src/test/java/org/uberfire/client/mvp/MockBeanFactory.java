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
package org.uberfire.client.mvp;

import org.uberfire.client.workbench.BeanFactory;
import org.uberfire.client.workbench.Position;
import org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelPresenter;
import org.uberfire.client.workbench.widgets.panels.WorkbenchPanelPresenter;
import org.uberfire.client.workbench.widgets.panels.WorkbenchPartPresenter;
import org.uberfire.client.workbench.model.PanelDefinition;
import org.uberfire.client.workbench.model.PartDefinition;
import org.uberfire.client.workbench.widgets.dnd.CompassDropController;
import org.uberfire.client.workbench.widgets.panels.HorizontalSplitterPanel;
import org.uberfire.client.workbench.widgets.panels.VerticalSplitterPanel;

import com.google.gwt.user.client.ui.IsWidget;
import org.uberfire.client.workbench.widgets.panels.WorkbenchPanelView;

/**
 * Mock BeanFactory that doesn't use CDI.
 */
public class MockBeanFactory
        implements
        BeanFactory {

    @Override
    public WorkbenchPartPresenter newWorkbenchPart( final IsWidget titleWidget,
                                                    final PartDefinition definition ) {
        final WorkbenchPartPresenter part = new WorkbenchPartPresenter( new MockWorkbenchPartView() );
        part.setTitleWidget( titleWidget );
        part.setDefinition( definition );
        return part;
    }

    @Override
    public WorkbenchPanelPresenter newWorkbenchPanel( final PanelDefinition definition ) {
        final RootWorkbenchPanelPresenter panel = new RootWorkbenchPanelPresenter( new MockWorkbenchPanelView(),
                                                                                   null,
                                                                                   null,
                                                                                   null );
        panel.setDefinition( definition );
        return panel;
    }

    @Override
    public HorizontalSplitterPanel newHorizontalSplitterPanel( final WorkbenchPanelView eastPanel,
                                                               final WorkbenchPanelView westPanel,
                                                               final Position position,
                                                               final Integer preferredSize,
                                                               final Integer preferredMinSize ) {
        return null;
    }

    @Override
    public VerticalSplitterPanel newVerticalSplitterPanel( final WorkbenchPanelView northPanel,
                                                           final WorkbenchPanelView southPanel,
                                                           final Position position,
                                                           final Integer preferredSize,
                                                           final Integer preferredMinSize ) {
        return null;
    }

    @Override
    public CompassDropController newDropController( final WorkbenchPanelView view ) {
        return null;
    }

    @Override
    public void destroy( final Object o ) {
    }

}
