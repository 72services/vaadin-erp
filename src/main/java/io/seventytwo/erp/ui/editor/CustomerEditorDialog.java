package io.seventytwo.erp.ui.editor;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import io.seventytwo.db.tables.records.CustomerRecord;

@UIScope
@SpringComponent
public class CustomerEditorDialog extends Dialog {

    private final CustomerEditor customerEditor;

    public CustomerEditorDialog(CustomerEditor customerEditor) {
        this.customerEditor = customerEditor;

        setHeight("600px");
        setWidth("800px");

        Button cancelButton = new Button("Cancel");
        cancelButton.addClickListener(event -> close());
        this.customerEditor.setCancel(cancelButton);

        add(customerEditor);
    }

    public void open(CustomerRecord customer) {
        customerEditor.setCustomer(customer);
        super.open();
    }
}
