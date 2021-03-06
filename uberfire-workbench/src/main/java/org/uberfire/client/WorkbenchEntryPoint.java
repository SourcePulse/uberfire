/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.client;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.uberfire.client.resources.WorkbenchResources;
import org.uberfire.client.workbench.Workbench;

@EntryPoint
public class WorkbenchEntryPoint {

    @Inject
    private Workbench         workbench;

    private final SimplePanel appWidget = new SimplePanel();

    @PostConstruct
    public void init() {
        appWidget.add( workbench );
    }

    @AfterInitialization
    public void startApp() {
        loadStyles();
        RootLayoutPanel.get().add( appWidget );
    }

    private void loadStyles() {
        //Ensure CSS has been loaded
        WorkbenchResources.INSTANCE.CSS().ensureInjected();
    }

}
