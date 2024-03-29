/* eslint-disable */
import { NavLink, Route, Switch } from "react-router-dom";
import LoginPage from "./LoginPage";

// import AboutPage from "./AboutPage";
// import FuelSavingsPage from "./containers/FuelSavingsPage";
import HomePage from "./HomePage";
import ProfilePage from "./ProfilePage";
import DiscoverPage from "./Discovery";

// import NotFoundPage from "./NotFoundPage";
import PropTypes from "prop-types";
import React from "react";
import { hot } from "react-hot-loader";

// This is a class-based component because the current
// version of hot reloading won't hot reload a stateless
// component at the top-level.


class App extends React.Component {
  render() {
    const activeStyle = { color: 'blue' };
    return (
      <div>
        <Switch>
          <Route path="/maps" component={HomePage} />
          <Route path="/profile" component={ProfilePage} />
          <Route path="/discover" component={DiscoverPage} />
          <Route path="/" component={LoginPage} />
        </Switch>
      </div>
    );
  }
}

App.propTypes = {
  children: PropTypes.element
};

export default hot(module)(App);