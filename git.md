# git 기초

## 0. 준비사항

* [git bash 설치.](https://gitforwindows.org/)
  * git 을 활용하기 위한 `CLI(Command Line Interface)`를 제공한다.
  * souce tree, github desktop 등을 통해 `GUI` 환경에서도 활용 가능하다.

## 1. 로컬저장소 활용하기

### 1.  저장소 초기화

```bash
$ git  init
Initialized empty Git repository in C:/Users/student/Desktop/TIL/.git/
(master) $


```

* 저장소(repository)를 초기화 하게 되면, `.git` 폴더가 해당 디렉토리에 생성된다.
* bash 장에서는 (master) 라고 표기된다.
  * 현재 브랜치가 master라는 것을 의미함.

## 2. add - stageing area

> git으로 관리되는 파일들은 Working directory(작업환경), Staging Area, commit 단계를 거쳐 이력에 저장된다.

```bash
$ git add a.txt #파일명
$ git add images/ #폴더명
$ git add . #현재 디렉토리의 모든 파일 및 폴더
```

* add 전 상태

```bash
$ git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        git.md
        image/
        markdown.md

nothing added to commit but untracked files present (use "git add" to track)

```

* add 후

```bash
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   git.md
        new file:   "image/\353\213\244\354\232\264\353\241\234\353\223\234.jpg"
        new file:   markdown.md

```

## commit

> 커밋은 코드의 이력을 남기는 과정이다.

```bash
$ git commit -m '커밋 메시지'
[master (root-commit) 13be642] 마크다운 및 git기초 정리
 3 files changed, 102 insertions(+)
 create mode 100644 git.md
 create mode 100644 "image/\353\213\244\354\232\264\353\241\234\353\223\234.jpg"
 create mode 100644 markdown.md
```

* 커밋 메시지는 항상 해당 이력에 대한 정보를 담을 수 있도록 작성하는 것이 좋다.

* 일관적인 커밋 메시지를 작성하는 습관을 들이다.

* 이력 확인을 위해서는 아래의 명령어를 활용한다.

* ```bash
  $ git log
  commit 13be642a93d7deab9e51b841b4a7ff240f688696 (HEAD -> master)
  Author: Hae-gun <newchk610gmail.com>
  Date:   Mon Dec 16 14:25:53 2019 +0900
  
      마크다운 및 git기초 정리
  
  ```

**항상 status 명령어를 통해 git의 상태를 확인하자! commit 이후에는 log 명령어를 통해 이력들을 확인하자!**

## 업로드

```bash
git remote add origin https://github.com/Hae-gun/TIL.git
git push -u origin master
```



