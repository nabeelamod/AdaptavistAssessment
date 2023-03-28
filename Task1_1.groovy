//Get custom fields num_1 and num_2
def number1 = issue.getCustomFieldValue("num_1")
def number2 = issue.getCustomFieldValue("num_2")

//Returns the sum of the two number fields
return number1 + number2
