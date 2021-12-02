# osteaching
综合课程设计后端
初始状态下的main分支已完成学生登录的编写，以供参考。

## 关于命名规范
除了实体类和与实体类绑定的repository接口外（没办法，数据库带了t_字眼），类名大驼峰属性名小驼峰

## 关于哪些文件不要动，哪些文件随便动，配合git工作流食用
test文件夹下的东西随便玩，我已经加到gitignore里了。

实体类与实体类绑定的repository接口不要动了。*如果你需要在某个与实体类绑定repository接口里添加新的抽象方法，就再建新的repository接口，命名描述你的工作，如：StudentLoginRepository。*

![image](https://user-images.githubusercontent.com/54850606/144381056-cd9e444b-e913-4ff8-8da4-32d093bd836e.png)

上图的东西别动

与自己的工作无关的东西尽量别动。

## 关于git工作流（感谢zyc）
1. 开始工作前，请务必在GitHub上属于你远程分支，分支用`dev-你名字的缩写`命名，如dev-cdc

2. 使用`git pull`拉取最新远程仓库

3. 在本地创建同名分支，比如创建远程origin的dev分支到本地并切换到dev分支，可以用这个命令创建本地dev分支并将两者关联简化后续命令：

   ```
   $ git checkout -b dev origin/dev
   ```

4. 开发结束后，使用`git add 文件名`与`git commit -m "commit信息写在这里"`上传更改到本地，commit信息因为我们人也不多就随便写写吧中英文都可以，写清楚就ok。

   建议用这样的方式书写commit信息：

   ```
   第一行：大致写一下干了啥，比去创建了哪个文件，增加了哪个功能等等
   空一行
   第三行：稍微详细一点说明一下本次提交完成的工作
   ```

   **特别注意！！**朋友们上传前一定逐个检查修改的地方，以免混入错误造成麻烦，呜呜呜。

   **特别注意x2！！**请务必少量多次进行commit，尽量一个文件或页面一个commit，否则很难在一个commit信息中说明白一堆更改都干了啥。

5. push到远端之前一定记得检查一下和当前远程master分支有没有冲突，具体做法：
   - `git switch master`转到本地master分支
   - `git pull`拉一下master上的更改，啥也没有的话切回去直接`git push`就可以了
   - 如果有更改，切回去执行`git merge master`把更改合并过来，没有冲突的话直接`git push`
   - 有冲突的话手动解决一下再push
6. 所有更改上传完成后点击`Pull Request`
7. 对git工作流使用还有不懂的直接问或者网上搜。遇到不得不动别人写的东西的时候（比如repository下的那些接口），说清楚，然后一起手动解决冲突QAQ。
