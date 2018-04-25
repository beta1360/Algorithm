from compress import compress
from decompress import decompress
import os

if __name__ == "__main__":
    filename = input("Input filename >> ")

    h = compress(filename)
    output_path, mapping = h.compress()
    original_file_size = os.stat(filename).st_size
    compress_file_size = os.stat(output_path).st_size
    compression_ratio = (compress_file_size/original_file_size)*100

    print("\n---------- Compress Result-----------")
    print("Compressed file path: %s"  %(output_path))
    print("Compressed file size: %d bytes" %(compress_file_size))
    print("Compressed ratio: %.3f %%"  %(compression_ratio))

    d = decompress(output_path, mapping)
    decom_path = d.decompress()
    decompress_file_size = os.stat(decom_path).st_size
    restoration_ratio = (decompress_file_size/original_file_size)*100

    print("\n---------- Decompress Result-----------")
    print("Decompressed file path: %s" %(decom_path))
    print("Decompressed file size: %d bytes" %(decompress_file_size))
    print("Restoration ratio : %.3f %%" %(restoration_ratio))
