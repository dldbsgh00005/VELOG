
<img width="578" height="208" alt="image" src="https://github.com/user-attachments/assets/a0628244-657d-4fc2-bfc9-b2fa0d14fce6" />

<img width="594" height="245" alt="image" src="https://github.com/user-attachments/assets/9aebff74-d184-4eba-9969-3be4b9d14231" />

<img width="595" height="253" alt="image" src="https://github.com/user-attachments/assets/75ee0742-9017-44b7-b6d9-10cb2cc23078" />

<img width="597" height="337" alt="image" src="https://github.com/user-attachments/assets/7012b83a-03f6-4e40-ac51-967dd7f50177" />

<img width="592" height="215" alt="image" src="https://github.com/user-attachments/assets/020825bf-b53b-4e22-8a1d-3e1bc33d1b34" />

<img width="388" height="150" alt="image" src="https://github.com/user-attachments/assets/b72582ad-69ec-4e92-87f7-3ce5052b4821" />

<img width="354" height="487" alt="image" src="https://github.com/user-attachments/assets/58a3f38e-7808-4288-b877-d8d80b272f83" />

```
double autoThresh = Cv2.Threshold(src, dst, 0, 255, ThresholdTypes.Binary | ThresholdTypes.Otsu);
Console.WriteLine($"Otsu가 계산한 임계값: {autoThresh}");

```

```

Mat src = Cv2.ImRead("input.png", ImreadModes.Grayscale);
Mat dst = new Mat();
double otsuThresh = Cv2.Threshold(src, dst, 0, 255, ThresholdTypes.Binary | ThresholdTypes.Otsu);
Console.WriteLine($"Otsu 임계값: {otsuThresh}");
Cv2.ImWrite("output.png", dst);

```


