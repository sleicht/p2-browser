/*******************************************************************************
 * Copyright (c) 2011 Igor Fedorenko
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Igor Fedorenko - initial API and implementation
 *******************************************************************************/

package com.ifedorenko.p2browser.dialogs;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RepositoryLocationDialog
    extends TrayDialog
{

    private URI location;

    private Text message;

    private Combo combo;

    /**
     * Create the dialog.
     *
     * @param parentShell
     */
    public RepositoryLocationDialog( Shell parentShell )
    {
        super( parentShell );
        setShellStyle( SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL );
        setHelpAvailable( false );
    }

    @Override
    protected Control createDialogArea( Composite parent )
    {
        Composite container = (Composite) super.createDialogArea( parent );
        container.setLayout( new GridLayout( 2, false ) );

        Label lblLocation = new Label( container, SWT.NONE );
        lblLocation.setLayoutData( new GridData( SWT.RIGHT, SWT.CENTER, false, false, 1, 1 ) );
        lblLocation.setText( "Location" );

        combo = new Combo( container, SWT.NONE );
        combo.addModifyListener( new ModifyListener()
        {
            @Override
			public void modifyText( ModifyEvent e )
            {
                try
                {
                    location = new URI( combo.getText() );
                    message.setText( "" );
                    getButton( IDialogConstants.OK_ID ).setEnabled( true );
                }
                catch ( URISyntaxException ex )
                {
                    message.setText( ex.getMessage() );
                    getButton( IDialogConstants.OK_ID ).setEnabled( true );
                }
            }
        } );
        combo.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false, 1, 1 ) );

        message = new Text( container, SWT.BORDER | SWT.READ_ONLY );
        message.setEditable( false );
        message.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false, 2, 1 ) );

        return container;
    }

    @Override
    public void create()
    {
        super.create();
//        combo.add( "http://download.eclipse.org/scout/releases/3.10" );
//        combo.add( "http://archive.eclipse.org/scout/releases/3.10" );
//        combo.add( "https://scout.bsiag.com/repository/tools-scout-3.10-SR1-RC5-public" );
//        combo.add( "http://download.eclipse.org/scout/releases/4.0" );
//        combo.add( "http://archive.eclipse.org/scout/releases/4.0" );
//        combo.add( "http://download.eclipse.org/scout/releases/5.0" );
//        combo.add( "http://archive.eclipse.org/scout/releases/5.0" );
//        combo.add( "http://download.eclipse.org/scout/releases/5.1" );
//        combo.add( "http://archive.eclipse.org/scout/releases/5.1" );
        combo.add( "https://scout.bsiag.com/repository/nebula.snapshot/" );
        combo.add( "https://scout.bsiag.com/repository/eclipse.releases.neon" );
        combo.add( "https://scout.bsiag.com/repository/eclipse.releases.mars" );
        combo.add( "https://scout.bsiag.com/repository/eclipse.releases.luna" );
        combo.add( "https://scout.bsiag.com/repository/scout.jaxws22/" );
//        combo.add( "https://scout.bsiag.com/repository/eclipse.releases.kepler" );
//        combo.add( "https://scout.bsiag.com/repository/eclipse.releases.juno" );
//        combo.add( "https://scout.bsiag.com/repository/eclipse.releases.indigo" );
//        combo.add( "https://scout.bsiag.com/repository/eclipse.releases.helios" );
//        combo.add( "https://scout.bsiag.com/repository/eclipse.releases.galileo" );

//        combo.add( "https://scout.bsiag.com/repository/orbit-S20130427215344" );

        // combo.add( "http://download.eclipse.org/eclipse/updates/4.5" );
        // combo.add( "http://download.eclipse.org/eclipse/updates/4.4" );
        // combo.add( "http://download.eclipse.org/eclipse/updates/4.3" );
        // combo.add( "http://download.eclipse.org/eclipse/updates/4.2" );
        // combo.add( "http://download.eclipse.org/eclipse/updates/3.8" );
        // combo.add( "http://download.eclipse.org/eclipse/updates/3.7" );
        // combo.add( "http://download.eclipse.org/eclipse/updates/3.6" );
        // combo.add( "http://download.eclipse.org/eclipse/updates/3.5" );
    }

    @Override
    protected void createButtonsForButtonBar( Composite parent )
    {
        Button button = createButton( parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true );
        button.setEnabled( false );
        createButton( parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false );
    }

    @Override
    protected void configureShell( Shell newShell )
    {
        super.configureShell( newShell );
        newShell.setText( "Repository location" );
    }

    @Override
    protected Point getInitialSize()
    {
        return new Point( 450, 300 );
    }

    public URI getLocation()
    {
        return location;
    }
}
