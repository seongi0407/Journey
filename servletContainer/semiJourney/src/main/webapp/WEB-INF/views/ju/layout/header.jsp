<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div>빈칸</div>
	<div>로고</div>
	<div>
		<c:if test="${not empty loginAdminVo}">
			<div>
				<span>: ${sessionScope.loginAdminVo.name}</span>
				<br>
				<button onclick="location.href = '/journey/admin/logout'">로그아웃</button>
			</div>
		</c:if>
        
		<c:if test="${not empty loginHostVo}">
			<div>
				<a download href="/journey/resources/upload/${loginHostVo.profile}">프로필 사진 다운로드 받기</a>
				<img
					width="100px"
					height="100px"
					alt="프로필 사진"
					src="/journey/resources/upload/${loginHostVo.profile}"
				>
				<span>이름: ${sessionScope.loginHostVo.name}</span>
				<br>
				<button onclick="location.href = '/journey/host/logout'">로그아웃</button>
			</div>
		</c:if>

		<c:if test="${not empty loginMemberVo}">
			<div>
				<a download href="/journey/resources/upload/${loginMemberVo.profile}">프로필 사진 다운로드 받기</a>
				<img
					width="100px"
					height="100px"
					alt="프로필 사진"
					src="/journey/resources/upload/${loginMemberVo.profile}"
				>
				<span>이름: ${sessionScope.loginMemberVo.name}</span>
				<br>
				<button onclick="location.href = '/journey/member/logout'">로그아웃</button>
			</div>
		</c:if>

		<c:if test="${empty loginAdminVo && empty loginHostVo && empty loginMemberVo}">
			<div>
				<button onclick="location.href = '/journey/host/join'">호스트 회원가입</button>
				<button onclick="location.href = '/journey/member/join'">사용자 회원가입</button>
				<button onclick="location.href = '/journey/admin/login'">관리자 로그인</button>
				<button onclick="location.href = '/journey/host/login'">호스트 로그인</button>
				<button onclick="location.href = '/journey/member/login'">사용자 로그인</button>
			</div>
		</c:if>
	</div>
</header>
