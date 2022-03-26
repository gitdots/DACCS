#ifndef PF_CHAIR_HPP
#define PF_CHAIN_HPP

#include <iostream>
#include <memory>

class Chair{

    public:
        Chair();
        int x;

};

typedef std::shared_ptr<Chair> ChairPtr;

#endif