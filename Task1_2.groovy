import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.event.type.EventDispatchOption

def issueManager = ComponentAccessor.issueManager
def commentManager = ComponentAccessor.commentManager
def user = ComponentAccessor.jiraAuthenticationContext.loggedInUser
def issueId = event.issue.id
def issue = issueManager.getIssueObject(issueId)

// Get the issue's latest comment
def latestComment = commentManager.getComments(issue).last()

// Update the issue description with the latest comment
issue.setDescription(latestComment.body)

// Update the issue
ComponentAccessor.issueManager.updateIssue(user, issue, EventDispatchOption.ISSUE_UPDATED, false)
