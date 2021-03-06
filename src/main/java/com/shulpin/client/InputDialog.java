package com.shulpin.client;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.ui.*;

public class InputDialog extends DialogBox {

    private DialogBoxOpener opener = null;
    private String author;
    private String title;
    private int pagesCount;
    private int publishedYear;

    private Button ok;
    private TextBox authorTextBox;
    private TextBox titleTextBox;
    private TextBox pagesCountTextBox;
    private TextBox publishedYearTextBox;


    public InputDialog() {
        // Set the dialog box's caption.
        setText("InputBook");
        setModal(true);
        // Enable animation.
        setAnimationEnabled(true);
        Label authorLabel = new Label("Author Name:");
        authorTextBox = new TextBox();
        authorTextBox.addKeyUpHandler(new MyKeyUpHandler());
        authorTextBox.addStyleName("notvalid");
        Label titleLabel = new Label("Title:");
        titleTextBox = new TextBox();
        titleTextBox.addKeyUpHandler(new MyKeyUpHandler());
        titleTextBox.addStyleName("notvalid");
        Label pagesCountLabel = new Label("Pages Count::");
        pagesCountTextBox = new TextBox();
        pagesCountTextBox.addKeyUpHandler(new MyKeyUpHandler());
        pagesCountTextBox.addStyleName("notvalid");
        Label publishedYearLabel = new Label("Published Year:");
        publishedYearTextBox = new TextBox();
        publishedYearTextBox.addKeyUpHandler(new MyKeyUpHandler());
        publishedYearTextBox.addStyleName("notvalid");
        // DialogBox is a SimplePanel, so you have to set its widget
        // property to whatever you want its contents to be.
        ok = new Button("OK");
        ok.setEnabled(false);
        ok.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                author = authorTextBox.getText();
                title = titleTextBox.getText();
                    pagesCount = Integer.valueOf(pagesCountTextBox.getText());
                    publishedYear = Integer.valueOf(publishedYearTextBox.getText());

                InputDialog.this.hide();
                if (opener != null)
                    opener.dialogBoxCancelled();
            }
        });


        HorizontalPanel panel = new HorizontalPanel();
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setSpacing(10);
        verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        VerticalPanel authorPanel = new VerticalPanel();
        authorPanel.add(authorLabel);
        authorPanel.add(authorTextBox);
        panel.add(authorPanel);

        VerticalPanel titlePanel = new VerticalPanel();
        titlePanel.add(titleLabel);
        titlePanel.add(titleTextBox);
        panel.add(titlePanel);

        VerticalPanel pagesPanel = new VerticalPanel();
        pagesPanel.add(pagesCountLabel);
        pagesPanel.add(pagesCountTextBox);
        panel.add(pagesPanel);

        VerticalPanel yearPanel = new VerticalPanel();
        yearPanel.add(publishedYearLabel);
        yearPanel.add(publishedYearTextBox);
        panel.add(yearPanel);

        verticalPanel.add(panel);
        verticalPanel.add(ok);

        setWidget(verticalPanel);
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setOpener(DialogBoxOpener opener) {
        this.opener = opener;
    }

    public class MyKeyUpHandler implements KeyUpHandler {

        @Override
        public void onKeyUp(KeyUpEvent keyUpEvent) {
            author = authorTextBox.getText();
            title = titleTextBox.getText();
            try {
                pagesCount = Integer.valueOf(pagesCountTextBox.getText());
            } catch (Exception ex) {
                ok.setEnabled(false);
                pagesCountTextBox.removeStyleName("valid");
                pagesCountTextBox.addStyleName("notvalid");
            }
            try {
                publishedYear = Integer.valueOf(publishedYearTextBox.getText());
            } catch (Exception ex) {
                ok.setEnabled(false);
                publishedYearTextBox.removeStyleName("valid");
                publishedYearTextBox.addStyleName("notvalid");;
            }

            if(author != ""){authorTextBox.addStyleName("valid");}
            else{ok.setEnabled(false);authorTextBox.addStyleName("notvalid");}

            if(title != ""){titleTextBox.addStyleName("valid");}
            else{ok.setEnabled(false);titleTextBox.addStyleName("notvalid");}

            if(pagesCount>-1){pagesCountTextBox.removeStyleName("notvalid");pagesCountTextBox.addStyleName("valid");}
            else{ok.setEnabled(false);pagesCountTextBox.removeStyleName("valid");pagesCountTextBox.addStyleName("notvalid");}

            if(publishedYear<2018){publishedYearTextBox.removeStyleName("notvalid");publishedYearTextBox.addStyleName("valid");}
            else{ok.setEnabled(false);publishedYearTextBox.removeStyleName("valid");publishedYearTextBox.addStyleName("notvalid");}
            if((author != "")&&(title != "")&&(pagesCount>-1)&&(publishedYear<2018)){
                ok.setEnabled(true);
            }

        }
    }


}
