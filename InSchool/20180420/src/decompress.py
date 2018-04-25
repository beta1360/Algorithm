'''
- original code : https://github.com/bhrigu123/huffman-coding/blob/master/huffman.py
- Modified by KeonHeeLee
'''

import os

"""
Code for Huffman Coding, compression and decompression. 
Explanation at http://bhrigu.me/blog/2017/01/17/huffman-coding-python-implementation/
"""

class decompress:
    def __init__(self, filename, mapping):
        self.filename = filename
        self.mapping = mapping

    def remove_padding(self, padded_encoded_text):
        padded_info = padded_encoded_text[:8]
        extra_padding = int(padded_info, 2)

        padded_encoded_text = padded_encoded_text[8:]
        encoded_text = padded_encoded_text[:-1 * extra_padding]

        return encoded_text

    def decode_text(self, encoded_text):
        current_code = ""
        decoded_text = ""

        for bit in encoded_text:
            current_code += bit
            if (current_code in self.mapping):
                character = self.mapping[current_code]
                decoded_text += character
                current_code = ""

        return decoded_text

    def decompress(self):
        filename, file_extension = os.path.splitext(self.filename)
        output_filename = filename + "_restore.txt"

        try:
            file = open(self.filename, 'rb')
        except:
            print("ERROR : Can't find or read the path::%s" % (self.filename))
            exit(0)

        output = open(output_filename, 'w')

        bit_string = ""

        byte = file.read(1)
        while len(byte) > 0:
            byte = ord(byte)
            bits = bin(byte)[2:].rjust(8, '0')
            bit_string += bits
            byte = file.read(1)

        encoded_text = self.remove_padding(bit_string)
        decompressed_text = self.decode_text(encoded_text)
        output.write(decompressed_text)

        return output_path
