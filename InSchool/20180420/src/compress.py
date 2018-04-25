'''
- original code : https://github.com/bhrigu123/huffman-coding/blob/master/huffman.py
- Modified by KeonHeeLee
'''
import heapq
import os
from util.HeapNode import HeapNode

"""
Code for Huffman Coding, compression and decompression. 
Explanation at http://bhrigu.me/blog/2017/01/17/huffman-coding-python-implementation/
"""

class compress:
    def __init__(self, filename):
        self.filename = filename
        self.heap = []
        self.codes = {}
        self.mapping = {}

    def make_frequency_dict(self, content):
        frequency = {}
        for character in content:
            if not character in frequency:
                frequency[character] = 0
            frequency[character] += 1
        return frequency

    def make_heap(self, frequency):
        for key in frequency:
            node = HeapNode(key, frequency[key])
            heapq.heappush(self.heap, node)

    def merge_nodes(self):
        while (len(self.heap) > 1):
            node1 = heapq.heappop(self.heap)
            node2 = heapq.heappop(self.heap)

            merged = HeapNode(None, node1.freq + node2.freq)
            merged.left = node1
            merged.right = node2

            heapq.heappush(self.heap, merged)

    def make_codes_helper(self, root, current_code):
        if (root == None):
            return

        if (root.char != None):
            self.codes[root.char] = current_code
            self.mapping[current_code] = root.char
            return

        self.make_codes_helper(root.left, current_code + "0")
        self.make_codes_helper(root.right, current_code + "1")

    def make_codes(self):
        root = heapq.heappop(self.heap)
        current_code = ""
        self.make_codes_helper(root, current_code)

    def get_encoded_text(self, content):
        encoded_text = ""
        for character in content:
            encoded_text += self.codes[character]
        return encoded_text

    def pad_encoded_text(self, encoded_text):
        extra_padding = 8 - len(encoded_text) % 8
        for i in range(extra_padding):
            encoded_text += "0"

        padded_info = "{0:08b}".format(extra_padding)
        encoded_text = padded_info + encoded_text
        return encoded_text

    def get_byte_array(self, padded_encoded_text):
        if (len(padded_encoded_text) % 8 != 0):
            print("Encoded text not padded properly")
            exit(0)

        b = bytearray()
        for i in range(0, len(padded_encoded_text), 8):
            byte = padded_encoded_text[i:i + 8]
            b.append(int(byte, 2))
        return b

    def compress(self):
        filename, file_extension = os.path.splitext(self.filename)
        output_filename = filename + "_compress.bin"

        try:
            file = open(self.filename, 'r+')
            output = open(output_filename, 'wb')
        except:
            print("ERROR : Can't find the path::%s" % (self.filename))
            exit(0)

        try:
            content = file.read()
        except:
            print("TYPE ERROR: Can't read this file::%s" % (self.filename))
            exit(0)

        content = content.rstrip()

        frequency = self.make_frequency_dict(content)
        self.make_heap(frequency)
        self.merge_nodes()
        self.make_codes()

        encoded_text = self.get_encoded_text(content)
        padded_encoded_text = self.pad_encoded_text(encoded_text)

        b = self.get_byte_array(padded_encoded_text)
        output.write(bytes(b))

        return output_filename, self.mapping
