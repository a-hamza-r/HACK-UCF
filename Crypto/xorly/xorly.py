#!/usr/bin/env python2

def encrypt(plaintext, key):

    ciphertext = []
    for i in xrange(0, len(plaintext)):
        ciphertext.append(ord(plaintext[i]) ^ ord(key[i%len(key)])) 

    return ''.join(map(chr, ciphertext))

decrypt = encrypt

'''
I'll give you a sample of how this works:

Plaintext: 
"Here is a sample. Pay close attention!"

Ciphertext: (encoded in hex)
2e0c010d46000048074900090b191f0d484923091f491004091a1648071d070d081d1a070848

Flag: (encoded in hex, encrypted with the same key)
0005120f1d111c1a3900003712011637080c0437070c0015
'''

# Here is the actual solution to decrypt the flag
plaintext = "Here is a sample. Pay close attention!";
ciphertext = b'\x2e\x0c\x01\x0d\x46\x00\x00\x48\x07\x49\x00\x09\x0b\x19\x1f\x0d\x48\x49\x23\x09\x1f\x49\x10\x04\x09\x1a\x16\x48\x07\x1d\x07\x0d\x08\x1d\x1a\x07\x08\x48';
flag = b'\x00\x05\x12\x0f\x1d\x11\x1c\x1a\x39\x00\x00\x37\x12\x01\x16\x37\x08\x0c\x04\x37\x07\x0c\x00\x15';

key = encrypt(plaintext, ciphertext);
print decrypt(flag, key);
