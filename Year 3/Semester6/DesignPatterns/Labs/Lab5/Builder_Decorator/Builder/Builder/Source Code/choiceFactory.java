import java.util.*;
public class choiceFactory {
    multiChoice ui;
    //This class returns a Panel containing
    //a set of choices displayed by one of
    //several UI methods. 
    public multiChoice getChoiceUI(Vector choices) {
        if (choices.size() <=3)
            //return a panel of checkboxes
            ui = new checkBoxChoice(choices);
        else
            //return a multi-select listbox panel
            ui = new listboxChoice(choices);
        return ui;
    }            
}

