import mysql.connector as con
import pandas


class DBConnect(object):
    _db_connection = None
    _db_cur = None

    def __init__(self):
        self._db_connection = con.connect(host="localhost",  # your host, usually localhost
                       user="root",  # your username
                       passwd="",  # your password
                       db="empsense")
        self._db_cur = self._db_connection.cursor()

    def read(self, query):
        return pandas.read_sql(query, con=self._db_connection)

    def insert_update(self, query):
        try:
            self._db_cur.execute(query)
            self._db_connection.commit()
        except:
            self._db_connection.rollback()

    def delete(self, query):
        try:
            self._db_cur.execute(query)
            self._db_connection.commit()
        except:
            self._db_connection.rollback()

    def __del__(self):
        self._db_connection.close()
