# 개념 : 부모 엔티티에서 제거되면(고아) 삭제됨

List<Image> iamges; // [Image객체1, Image객체2]
images.remove(Image객체2); // 이 경우 Image객체2는 JPA에 의해 삭제된다.
