To configure an HTTPS server, the ssl parameter must be enabled on listening sockets in the server block, and the locations of the server certificate and private key files should be specified:
```
server {
    listen              443 ssl;
    server_name         www.example.com;
    ssl_certificate     www.example.com.crt;
    ssl_certificate_key www.example.com.key;
    ssl_protocols       TLSv1.2 TLSv1.3;
    ssl_ciphers         HIGH:!aNULL:!MD5;
    ...
}
```

The server certificate is a public entity. It is sent to every client that connects to the server. The private key is a secure entity and should be stored in a file with restricted access, however, it must be readable by nginx’s master process. The private key may alternately be stored in the same file as the certificate:
```
    ssl_certificate     www.example.com.cert;
    ssl_certificate_key www.example.com.cert;
```
