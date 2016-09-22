#Prime Number Kata

###Notes

My approach to this kata was first to research established prime number checking algorithms. In the end I settled on the Miller-Rabin algorithm. My reason
being that it not only is it very fast with a complexity of O(log(n)^4) for a deterministic variant (compared to say AKS which is about O(log(n)^6)). Also as 
it turns out Apache Commons Math already implements a prime checker using a deterministic implementation of the Miller-Rabin algorithm with some additional
optimizations for small primes.

In the spirit of approaching this exercise like I would any other problem I chose not to implement my own prime checking algorithm. The Apache Commons
implementation is well tested, and fast. Any implementation I could come up with in a short time span would likely provide little if any additional value.