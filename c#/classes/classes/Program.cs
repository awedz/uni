using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace classes
{
    class Program
    {
        static void Main(string[] args)
        {
            //Cookie a = new Cookie(true, 1, 1, 1);
            //Cookie b = new Cookie(false, 2, 1, 10);
            //Cookie c = new Cookie(true, 50, 30, 1);
            //a.PrintCookie();
            //b.PrintCookie();
            //c.PrintCookie();
            //c = a;
            //c.PrintCookie();
            //הנתונית השתנו כי העוגיה C מצביעה על העוגיה A עכשיו
            Car aa = new Car("Toyota");
            aa.MoreVromVroom(1);
            aa.MoreVromVroom(5);
            aa.LessVroomVroom(10);




            Console.ReadLine();
        }
    }
    #region Car
    public interface ICar
    {
        void MoreVromVroom(int speed);
        void LessVroomVroom(int speed);
        void NoVroomVroom();
    }
    public abstract class AB_Car : ICar
    {
        public readonly string Name;
        private int _speed;
        /// <summary>
        /// ctor set spped to 0
        /// </summary>
        public AB_Car(string name)
        {
            Name = name;
            _speed = 0;
        }
        /// <summary>
        /// Go less vroom vroom
        /// </summary>
        /// <param name="speed">How much less vroom vroom</param>
        public void LessVroomVroom(int speed)
        {
            _speed = _speed - speed > 0 ? _speed -= speed : 0;
            PrintDetails();
        }
        /// <summary>
        /// Go more vroom vroom
        /// </summary>
        /// <param name="speed">How much more vroom vroom</param>
        public void MoreVromVroom(int speed)
        {
            _speed += speed;
            PrintDetails();
        }
        /// <summary>
        /// no more vroom vroom
        /// </summary>
        public void NoVroomVroom()
        {
            _speed = 0;
        }
       /// <summary>
       /// Print out current speed
       /// </summary>
        public int GetCurrentSpeed()
        {
            return _speed;
        }
        abstract public void PrintDetails();

    }
    public class Car: AB_Car
    {
        public Car(string name):base(name)
        {
        }

        public override void PrintDetails()
        {
            var printStr = GetCurrentSpeed() > 0 ? $"{Name} is going {GetCurrentSpeed()}" : $"{Name} has stopped";
            Console.WriteLine(printStr);
        }
    }
    public class CarManager
    {
        private List<Car> _CarList;
        public CarManager()
        {
            _CarList = new List<Car>();
        }
        public void AddCar(Car car)
        {
            _CarList.Add(car);
        }
    }

    #endregion


    #region cookie
    public class Cookie
    {
        private readonly bool _IsGluten;
        private readonly int _EggCount;
        private readonly int _Suger;
        private readonly int _Flour;
        private readonly bool _IsEmpty;
        /// <summary>
        /// constractor for cookie
        /// </summary>
        /// <param name="isGluten">Does it have gluten?</param>
        /// <param name="eggCount">How many eggs?</param>
        /// <param name="suger">How much suger in grams?</param>
        /// <param name="flour">How much flour in grams?</param>
        public Cookie (bool isGluten,int eggCount,int suger,int flour)
        {
            _IsGluten = isGluten;
            _EggCount = eggCount;
            _Suger = suger;
            _Flour = flour;
            _IsEmpty = false;
        }

        /// <summary>
        /// Empty constractor to set that it is empty
        /// </summary>
        public Cookie()
        {
            _IsEmpty = true;
        }
        /// <summary>
        /// Print out Cookie
        /// </summary>
        public void PrintCookie()
        {
            var printStr = !_IsEmpty ? $"has gluten:{_IsGluten}\neggs:{_EggCount}\nsuger:{_Suger}\nflour:{_Flour}" : "cookie is empty";
            Console.WriteLine(printStr);
        }
    }
    #endregion
}
