/**
* The Interactive interface defines the behavior for objects that can run an interactive menu loop in the console 
* and interact with a CourseConnect object provided as a parameter.
*/

package io;

import main.CourseConnect;

public interface Interactive {

    /**
    * This method loops an interactive console menu for the CourseConnect object provided as a parameter.
    *
    * @param cc the CourseConnect object which the interactive loop will interact with.
    */
    public void Loop(CourseConnect cc);

}