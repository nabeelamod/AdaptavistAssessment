import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.event.type.EventDispatchOption

def issueManager = ComponentAccessor.issueManager
def customFieldManager = ComponentAccessor.customFieldManager

def user = ComponentAccessor.jiraAuthenticationContext.loggedInUser
def textField = customFieldManager.getCustomFieldObjectByName("textField")
def selectField = customFieldManager.getCustomFieldObjectByName("selectList")

def issueId = event.issue.id
def issue = issueManager.getIssueObject(issueId)

//Update text field
issue.setCustomFieldValue(textField, "Updated")

//Update Select List 
issue.getCustomFieldValue(selectField).setValue("Updated")

ComponentAccessor.issueManager.updateIssue(user, issue, EventDispatchOption.ISSUE_UPDATED, false)
