```
# branch
git branch [branch-name]

# commit
git commit -m "[message]" // git add 된 변경 사항을 메시지와 함께 커밋
git commit -am "[message]" // 신규 생성된 파일이 없을 때 git add + git commit을 동시에 수행

# fetch
git fetch -p // 원격 브랜치 로컬에 동기화
git fetch -prune // 원격 브랜치 로컬에 동기화

# switch
git switch [branch-name]

# push
git push // 현재 commit된 내용을 원격 브랜치에 동기화
git push origin --delete [branch-name] // 원격 브랜치 삭제

# pull
git pull // 모든 원격 브랜치의 내용을 로컬에 동기화
git pull origin [branch-name] 특정 원격 브랜치의 내용을 로컬에 동기화

```
