{\rtf1\ansi\ansicpg1252\cocoartf2708
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red202\green202\blue202;}
{\*\expandedcolortbl;;\cssrgb\c83137\c83137\c83137;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs24 \cf2 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 import com.atlassian.jira.component.ComponentAccessor\
\
//Gets the Priority and Summary Fields\
def priorityField = getFieldById(getFieldChanged())\
def summaryField = getFieldById("summary")\
\
//Gets the value of the Priority Field\
def priorityValue = priorityField.getValue().getName()\
\
//Gets the value of the Summary Field\
def summaryValue = summaryField.getValue()\
\
//Checks if the Priority is High or Highest\
if (priorityValue == "High" || priorityValue == "Highest")\
\{\
    if (!summaryValue.contains("URGENT: ")) \{\
        summaryField.setFormValue("URGENT: " + summaryValue)\
    \}\
\}\
else\
\{\
    def str = summaryValue.replace("URGENT: ", "")\
    summaryField.setFormValue(str)\
\}}