```
package packageName;

@RestController
@Slf4j
public class FileUpload{

  @GetMapping("/file")
  public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile[] files ){

    List<Map<String, Object>> fileList = new ArrayList<>();

    for(MultipartFile file : files){
        log.info("filename : " + file.getOriginalFileName);

        UUID uuid = UUID.randomUUID();
        String originalFileName = file.getOriginalFileName(); 
        String saveFileName = uuid + originalFileName;
        String url = "C:\\users\\dldbs\\Pictures\\FileUpload";
        File saveFile = new File(url, saveFileName);

        file.transferTo(saveFile);

        Map<String, Object> m = new HashMap<>();
        m.put("fileName", file.getOriginalFileName());
        m.put("path", saveFile);
        m.put("size", file.getSize());

        fileList.add(m);
    }

    for(Map<String, Object> m : fileList){
        System.out.println(m.get("fileName"));
        System.out.println(m.get("path"));
        System.out.println(m.get("size"));
    }

    return new ResponseEntity<String>("file uploaded", HttpStatus.OK);
  }

}
```
