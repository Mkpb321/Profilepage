import React, { Component } from "react";
import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Profile from "./Profile";
import ProfileEdit from "./ProfileEdit";

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path="/" exact={true} component={Profile} />
          <Route path="/profile/edit" component={ProfileEdit} />
        </Switch>
      </Router>
    );
  }
}

export default App;
