import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";
import { Button, Container, Form, FormGroup, Input, Label } from "reactstrap";

class ProfileEdit extends Component {
  emptyItem = {
    name: "",
    image: "",
    description: "",
    link: "",
  };

  constructor(props) {
    super();
    this.state = { item: this.emptyItem };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    fetch("/api/profile/1")
      .then((response) => response.json())
      .then((data) => this.setState({ item: data }));
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let item = { ...this.state.item };
    item[name] = value;
    this.setState({ item });
  }

  async handleSubmit(event) {
    event.preventDefault();
    const { item } = this.state;

    await fetch("/api/profile/1", {
      method: "PUT",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(item),
    });
    this.props.history.push("/");
  }

  render() {
    const { item } = this.state;
    return (
      <div>
        <Container>
          <h2>Edit Profile</h2>
          <Form onSubmit={this.handleSubmit}>
            <FormGroup>
              <Label for="name">Name</Label>
              <Input
                type="text"
                maxLength="16"
                name="name"
                id="name"
                value={item.name || ""}
                onChange={this.handleChange}
                autoComplete="name"
              />
            </FormGroup>
            <FormGroup>
              <Label for="image">Image</Label>
              <Input
                type="text"
                name="image"
                id="image"
                value={item.image || ""}
                onChange={this.handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup>
              <Label for="description">Description</Label>
              <textarea
                class="form-control"
                name="description"
                id="description"
                value={item.description || ""}
                onChange={this.handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup>
              <Label for="link">Link</Label>
              <Input
                type="text"
                name="link"
                id="link"
                value={item.link || ""}
                onChange={this.handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup>
              <Button color="primary" type="submit">
                Done
              </Button>{" "}
              <Button color="secondary" tag={Link} to="/">
                Cancel
              </Button>
            </FormGroup>
          </Form>
        </Container>
      </div>
    );
  }
}

export default withRouter(ProfileEdit);
