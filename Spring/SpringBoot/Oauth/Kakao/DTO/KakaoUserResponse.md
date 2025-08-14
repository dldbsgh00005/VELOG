```

// 유저 정보 응답
@Data
public class KakaoUserResponse {
    @JsonProperty(value = "id")
    private Long socialOauthId;
    @JsonProperty(value = "kakao_account")
    private KakaoAccount kakaoAccount;
//    @JsonProperty(value = "for_partner")
//    private Partner partner;

    @Data
    public static class KakaoAccount {
        private Profile profile; // 프로필
        private String email;
        private String name;
        private String gender;
        @JsonProperty(value = "age_range")
        private String ageRange;
        private String birthday;
        private String birthyear;

        @Data
        public static class Profile {
//            private String nickname;
            @JsonProperty(value = "profile_image_url")
            private String profileImageUrl;
        }

    }

//    @Data
//    public static class Partner {
//        @JsonProperty(value = "uuid")
//        private String uuid;
//    }
}




```
