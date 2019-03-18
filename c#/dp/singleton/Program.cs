using System;

namespace singleton
{
    class singleton
    {
        private singleton(){}
        private static readonly singleton _instance = new singleton();
        public static singleton GetInstance()
        {
            return _instance;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}
