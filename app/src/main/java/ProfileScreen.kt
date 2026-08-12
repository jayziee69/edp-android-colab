package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileForm(
    state: ProfileUiState,
    viewModel: ProfileViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "My Profile",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = state.name,
            onValueChange = viewModel::onNameChange,
            label = {
                Text("Full Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = state.email,
            onValueChange = viewModel::onEmailChange,
            label = {
                Text("Email")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = state.contactNumber,
            onValueChange = viewModel::onContactChange,
            label = {
                Text("Contact Number")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = state.address,
            onValueChange = viewModel::onAddressChange,
            label = {
                Text("Address")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = state.username,
            onValueChange = viewModel::onUsernameChange,
            label = {
                Text("Username")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Skills",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = state.newSkill,
                onValueChange = viewModel::onNewSkillChange,
                label = {
                    Text("Add a skill")
                },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    viewModel.addSkill()
                }
            ) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        state.skills.forEach { skill ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "• $skill",
                    modifier = Modifier.weight(1f)
                )

                TextButton(
                    onClick = {
                        viewModel.removeSkill(skill)
                    }
                ) {
                    Text("Remove")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                viewModel.showPreview()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Preview")
        }
    }
}

@Composable
fun ProfilePreview(
    state: ProfileUiState,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Profile Preview",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Name", fontWeight = FontWeight.Bold)
        Text(state.name)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Email", fontWeight = FontWeight.Bold)
        Text(state.email)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Contact Number", fontWeight = FontWeight.Bold)
        Text(state.contactNumber)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Address", fontWeight = FontWeight.Bold)
        Text(state.address)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Username", fontWeight = FontWeight.Bold)
        Text(state.username)

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Skills",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (state.skills.isEmpty()) {

            Text("No skills added yet.")

        } else {

            state.skills.forEach { skill ->
                Text(
                    text = "• $skill",
                    modifier = Modifier.padding(vertical = 3.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedButton(
            onClick = onBack
        ) {
            Text("Back to Edit")
        }
    }
}

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel()
) {

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    if (state.isPreview) {

        ProfilePreview(
            state = state,
            onBack = {
                viewModel.backToEdit()
            }
        )

    } else {

        ProfileForm(
            state = state,
            viewModel = viewModel
        )
    }
}