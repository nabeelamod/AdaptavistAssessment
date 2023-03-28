import com.atlassian.jira.component.ComponentAccessor

//Gets the Priority and Summary Fields
def priorityField = getFieldById(getFieldChanged())
def summaryField = getFieldById("summary")

//Gets the value of the Priority Field
def priorityValue = priorityField.getValue().getName()

//Gets the value of the Summary Field
def summaryValue = summaryField.getValue()

//Checks if the Priority is High or Highest
if (priorityValue == "High" || priorityValue == "Highest")
{
    if (!summaryValue.contains("URGENT: ")) {
        summaryField.setFormValue("URGENT: " + summaryValue)
    }
}
else
{
    def str = summaryValue.replace("URGENT: ", "")
    summaryField.setFormValue(str)
}
