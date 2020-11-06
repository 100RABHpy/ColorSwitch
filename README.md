# AP Project
Repo for project of our advance programming course

## How to contribute?
#### Install Git
Check this tutorial for installing git. [Tutorial](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git/) 
#### Clone repo 
`git clone https://github.com/100RABHpy/AP_project.git`  
This will create a local copy of this repo to your device.

### Things to do before making changes
Now you have the copy of code. But before making changes you have to set remote upstream. We do this so that we are in sync with main repo(repo from which we copied this).  
Now to set upstream do this.  
#### Go to the directory.  
`cd <repo-name>`  
#### Check current upstream.  
`git remote -v `  
#### Add upstream.  
`git remote add upstream https://github.com/100RABHpy/AP_project.git`  
#### Update repo
`git remote update`  
Now you have updated copy of repo. As you have added upstream, everytime you make a commit you should only do last step(`git remote update`).


