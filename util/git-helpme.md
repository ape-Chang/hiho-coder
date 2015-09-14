#### 添加Tag
`git tag ${tagname}`
#### push到远端库
`git push --tags`
#### 删除本地Tag
`git tag -d ${tagname}`
#### 删除远端Tag
`git push --delete origin ${tagname}`
#### 从某个Tag新建分支
`git checkout -b ${branchname} ${tagname}`
#### 合并分支
`git checkout ${branchname}` + `git merge ${branchname}`
合并时一般会发生冲突，修改后重新提交一次，合并就完成了