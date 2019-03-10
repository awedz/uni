//variables
//any
let x              : any = "a";
    x = 5;
//numbers

let num_int        : number = 2;
let num_float      : number = 2.2;
let num_nan        : number = NaN;
let num_cast       : number = Number("2.2");//2.2 as float
let num_parseint   : number = parseInt("2.2");//2 as int
let num_parsefloat : number = parseFloat("2.2");//2.2 as float
//strings
let str_normal     : string = "aaa";
let str_normal2    : string = 'aaa';
let str_backtick   : string = `aaa`;
let str_cast       : string = num_int.toString();
//boolean
let isBool         : boolean = true;
let isBool2        : boolean = false;
let isbigger       : boolean = 4 < 7;
//functions
//                                    return type : void number string bool
function func(a : number, b : number) : number {
    return a*b;
};
//optional param
function func_optional(a : number, b? : number) : void {
    console.log( a * b );
};
//args
function func_args( ...args : number[] ) : void {
    args.forEach( ( num ) => console.log( num ) );
};
