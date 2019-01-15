import sys
import random
from PIL import Image

BLOCKLEN = 1 # Adjust and be careful here.

img = Image.open('out copy.jpg')
width, height = img.size

xblock = width / BLOCKLEN
yblock = height / BLOCKLEN
blockmap = [(xb*BLOCKLEN, yb*BLOCKLEN, (xb+1)*BLOCKLEN, (yb+1)*BLOCKLEN)
        for xb in xrange(xblock) for yb in xrange(yblock)]

shuffle = list(blockmap)
random.shuffle(shuffle)

result = Image.new(img.mode, (width, height))
for box, sbox in zip(blockmap, shuffle):
    c = img.crop(sbox)
    result.paste(c, box)
result.save('test.jpg')