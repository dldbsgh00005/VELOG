// alpine 버전은 가벼움, 하지만 git, bash 등의 기본 옵션이 없어 오류의 가능성 있음 -> bash 등을 못찾아서 에러 발생 git은 기본으로 bash를 요구함 -> 실제로 not found 에러 발생
// alpine 보다는 무겁지만 git, bash 등이 기본 내장된 debian이나 buulseye 등을 쓰는 것이 안정적

// remoteUser : node가 자동 생성되어 있지 않은 경우 root로 재시도
// 오류 시 
// docker desktop 종료 
// wsl ( wsl --shutdown 명령어 )


<h1> ☑️ .devcontainer/devcontainer.json </h1>

```
{
	"name": "Node.js Alpine DevContainer",
	"image": "node:22-bullseye",
	"features": {
	},
	"forwardPorts": [
		3000,
		5173
	],
	"postCreateCommand": "npm install",
	"remoteUser": "node"
}

```
