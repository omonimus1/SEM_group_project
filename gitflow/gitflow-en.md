# Best git based work flow
###### This document is based on the Gitworkflow-it.md created by Giuseppe Matranga @mastrobirrario

This wiki exaplains the workflow and the development process based on the tolls of the Github platform. 

***

## Setting of the repository 
The software is distributed on the three following [branches](https://docs.gitlab.com/ee/user/project/repository/branches/):
*  `master`: contains the stable version of the software given to the users;
*  `preprod`: contain the instable (beta) version of the software given available just to the client and/or software tester
*  `devel`: contain the version of development of the software;

***

## Development cycle
The software development cycle needs to be managed with all the tools provided by Github 
The development cycle is based on the following way:  
*  **Planning**: in this step, the team will analize the software, creating a guide line to follow during the development process. 
*  **Issues**: Gli sviluppatori senior secondo la Milestone, creeranno le relative [Issues](https://docs.gitlab.com/ee/user/project/issues/), assegnandole agli sviluppatori che dovranno risolverle. Scorri giù per sapere come creare una issue.
*  **Solvining issues**: devs needs to solve their issues. Scroll down to read how to do it.
*  **Code review**: Peer coding review applied for coding review.
*  **Testing & Bug fixing**: client, and testers will have a limit time to test the software application, create new issues indicating all the bags discovered. 

***

## Make a new issue 

When you create a new issue you have to: 
*  Use a brief name and intuitive name 
*  Indicate inside the issue other details about it using the comment function
*  Use the issue forum sectin to speack with other colleborators about how to complete the task and close the issue
*  Assign an user for the complement of the issue
*  Give a max time 
*  Assign a milestone
*  Assign labels 

La label `To Do` è obbligatoria quando crei una nuova issue.

### List of essential labels
*  `Bug`: use this label to indicate/report an abnormal behaviour of the software application. 
*  `Critical Bug`: use this label to indicate/report a bug that stops execution of the software application. 
*  `Deprecate`:  use this label to indicate a feature that is deprecated. 
*  `Documentation`: this label is used when it's linked to the modification of a DocString, README or Wiki file. 

***

## Solve one issue
When you want to solve/close one issue, you MUST to:
*  Create a new branch 
*  Do your local updates.
*  Coding refactory.
*  Write relative documentation (if necessary) 
*  Create a Merge Request. 

### Create a branch
The name of a new branch has the following structure : `issueN_of_issue-short_description` or `feature-IssueNumber`.
For example: we are working on the issue #2 called Login Form, pur branch will be called: `issue#2-login` or `issue#2`.

#### Create a remote branch 

*  Create a new branch locally
```
git checkout -b issue#2
```
*  Load the new branch in the repository (remote)
```
git push -u origin issue#2
```
Adesso siamo pronti per effettuare le nostre modifiche.

#### Make a commit
```
git add filename or git add .
```
```
git commit -m "#2: login template form"
```
```
git push
```

#### Create a merge request

* [tutorial](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html).
*  Structure of the merge request `#number_of_issue issue full name` (ex.: #2 Login Form).
*  Assign to the merge request the same labels of the issue. 
*  Turn on / Able the options  `Squash commits` e `Delete source branch`.
*  Do the submit of the Merge Request.  
