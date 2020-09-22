import React, { Component } from 'react';
import { Button } from 'reactstrap';
import { Link } from 'react-router-dom';

class Profile extends Component {

  constructor(props) {
    super();
    this.state = { isLoading: true };
  }

  componentDidMount() {
    this.setState({ isLoading: true });

    fetch('api/profile')
      .then(response => response.json())
      .then(data => this.setState({ profile: data, isLoading: false }));
  }

  render() {
    const { profile, isLoading } = this.state;
  
    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
        <div class="profile">
          <img class="profile-image" src={profile.image} alt="Profile Picture" />
          <h5 class="card-title">{profile.name}</h5>
          <p class="card-text">{profile.description}</p>
          <p class="card-text"><a href={profile.link}>My Website</a></p>
          <Button color="primary" tag={Link} to={"/profile/edit"}>Edit</Button>
        </div>
    );
  }
}

export default Profile;