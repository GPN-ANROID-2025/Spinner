## Using AutocompleteTextView, Spinner, and RadioGroup/RadioButton

This section provides a brief overview of how to use AutocompleteTextView, Spinner, and RadioGroup/RadioButton in your Android project.

**1. AutocompleteTextView**

* **Purpose:** Displays a list of suggestions as the user types, allowing for quick and easy selection.
* **Implementation:**
    1. Create an instance of `AutocompleteTextView` in your layout XML file.
    2. Create an `ArrayAdapter` or a custom `Adapter` to populate the suggestions list.
    3. Set the `setAdapter()` method of the `AutocompleteTextView` with the adapter.
    4. Handle the `onTextChanged()` event to update the suggestions list dynamically.

**2. Spinner**

* **Purpose:** Displays a dropdown list of options for the user to select from.
* **Implementation:**
    1. Create an instance of `Spinner` in your layout XML file.
    2. Create an `ArrayAdapter` or a custom `Adapter` to populate the dropdown list.
    3. Set the `setAdapter()` method of the `Spinner` with the adapter.
    4. Handle the `onItemSelected()` event to retrieve the selected item.

**3. RadioGroup and RadioButton**

* **Purpose:** Allows the user to select only one option from a group of choices.
* **Implementation:**
    1. Create an instance of `RadioGroup` in your layout XML file.
    2. Add multiple `RadioButton` instances within the `RadioGroup`.
    3. Handle the `onCheckedChanged()` event of the `RadioGroup` to determine the selected radio button.
