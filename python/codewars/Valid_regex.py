# validate_pin("1234") == True
# validate_pin("12345") == False
# validate_pin("a234") == False

import re
def validate_pin(pin):
    p = re.compile('[*?\D]')
    a = p.findall(pin)
    return len(a) == 0 and (len(pin) == 4 or len(pin) == 6)