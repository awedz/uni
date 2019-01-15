import mysql.connector as db
from mysql.connector import errorcode

db_name = 'pythondb'
db_config = {
    'host':'localhost',
    'user':'kiril',
    'password':'1q2w3e4rasd'
}
db_con = db.connect(**db_config)
db_curser = db_con.cursor()
def ConnectToDatabase(cursor):
    try:
        cursor.execute('CREATE DATABASE {0}'.format(db_name))
    except db.Error as er:
        print(er)
    finally:
        cursor.close()


ConnectToDatabase(db_curser)


# db_curser.execute("SHOW DATABASES")
# if db_name in db_curser:
#     print(db_name)
# db_curser.close()