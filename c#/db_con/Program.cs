using System;
using System.Data.SqlClient;

namespace db_con
{
    class Program
    {
        static void Main(string[] args)
        {
            string conString = "Server=127.0.0.1;Database=testdb;Uid=root;Pwd=";
            SqlConnection db = null;

            try
            {
                using(db = new SqlConnection(conString))
                {
                    db.open();
                }
            }
            catch (System.Exception)
            {

                throw;
            }


            Console.WriteLine("Hello World!");
        }
    }
}
